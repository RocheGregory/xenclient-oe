# XenClient sysroot image
LICENSE = "GPLv2 & MIT"
LIC_FILES_CHKSUM = "file://${TOPDIR}/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe      \
                    file://${TOPDIR}/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

include xenclient-image-common.inc

COMPATIBLE_MACHINE = "(openxt-dom0)"

IMAGE_FSTYPES = "cpio.bz2"

# No thanks, we provide our own xorg.conf with the hacked Intel driver
# And we don't need Avahi
BAD_RECOMMENDATIONS += "xserver-xorg avahi-daemon avahi-autoipd"
# The above seems to be broken and we *really* don't want avahi!
PACKAGE_REMOVE = "avahi-daemon avahi-autoipd"

ANGSTROM_EXTRA_INSTALL += " \
			  " 
export IMAGE_BASENAME = "xenclient-sysroot-image"
export STAGING_KERNEL_DIR

FRIENDLY_NAME = "sysroot"

DEPENDS = "packagegroup-base packagegroup-xenclient-dom0 packagegroup-xenclient-dom0-extra"
IMAGE_INSTALL = "\
    ${ROOTFS_PKGMANAGE} \
    initscripts \
    modules \
    packagegroup-base \
    packagegroup-core-boot \
    packagegroup-xenclient-common \
    packagegroup-xenclient-dom0 \
    essential-target-builddepends \
    ${ANGSTROM_EXTRA_INSTALL}"

#IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

inherit image openxt
#inherit validate-package-versions
inherit xenclient-image-src-info
inherit xenclient-image-src-package
inherit xenclient-licences
require xenclient-version.inc

do_post_rootfs_commands() {
	sed -i 's|root:x:0:0:root:/home/root:/bin/sh|root:x:0:0:root:/root:/bin/bash|' ${IMAGE_ROOTFS}/etc/passwd;

	rm ${IMAGE_ROOTFS}/etc/hosts;
	ln -s /tmp/hosts ${IMAGE_ROOTFS}/etc/hosts;

	# Add initramfs
	cat ${DEPLOY_DIR_IMAGE}/openxt-initramfs-image-openxt-dom0.cpio.gz > ${IMAGE_ROOTFS}/boot/initramfs.gz;

	sed -i 's|1:2345:respawn:/sbin/getty 38400 tty1|#1:2345:respawn:/sbin/getty 38400 tty1|' ${IMAGE_ROOTFS}/etc/inittab;

	# Add input demon to inittab (temp hack)
	echo 'xi:5:respawn:/usr/bin/input_server >/dev/null 2>&1' >> ${IMAGE_ROOTFS}/etc/inittab;

	# Same with surfman
	echo 'xs:5:respawn:/usr/bin/watch_surfman >/dev/null 2>&1' >> ${IMAGE_ROOTFS}/etc/inittab;

	# Add dom0 console getty
	echo '1:2345:respawn:/sbin/getty 38400 tty1' >> ${IMAGE_ROOTFS}/etc/inittab;

	# Create mountpoint for /mnt/secure
	mkdir -p ${IMAGE_ROOTFS}/mnt/secure;

	# Create mountpoint for boot/system
	mkdir -p ${IMAGE_ROOTFS}/boot/system;

	# Remove unwanted packages specified above
	opkg-cl -f ${IPKGCONF_TARGET} -o ${IMAGE_ROOTFS} ${OPKG_ARGS} -force-depends remove ${PACKAGE_REMOVE};

	# Write coredumps in /var/cores
	echo 'kernel.core_pattern = /var/cores/%e-%t.%p.core' >> ${IMAGE_ROOTFS}/etc/sysctl.conf;
}

#zap root password for release images
ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'

addtask do_post_rootfs_commands after do_rootfs
addtask do_ship after do_rootfs before do_licences

