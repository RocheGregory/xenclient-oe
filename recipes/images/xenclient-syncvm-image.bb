# XenClient Synchronizer client VM image

include xenclient-image-common.inc
IMAGE_FEATURES += "package-management"

COMPATIBLE_MACHINE = "(openxt-syncvm)"

IMAGE_FSTYPES = "xc.ext3.vhd.gz"

ANGSTROM_EXTRA_INSTALL += ""

export IMAGE_BASENAME = "xenclient-syncvm-image"

DEPENDS = "packagegroup-base"

# ifplugd removed as busybox is now >= 1.15
IMAGE_INSTALL = "\
    ${ROOTFS_PKGMANAGE} \
    modules \
    packagegroup-core-boot \
    packagegroup-base \
    packagegroup-xenclient-common \
    bootage \
    kernel-modules \
    v4v-module \
    libv4v \
    libv4v-bin \
    rsyslog \
    openssh \
    blktap \
    wget \
    sync-client \
    xenclient-syncvm-tweaks \
    ${ANGSTROM_EXTRA_INSTALL}"

#IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

after_commands() {
    echo 'ca:12345:ctrlaltdel:/sbin/shutdown -t1 -a -r now' >> ${IMAGE_ROOTFS}/etc/inittab;
    sed -i 's|root:x:0:0:root:/home/root:/bin/sh|root:x:0:0:root:/root:/bin/bash|' ${IMAGE_ROOTFS}/etc/passwd;
    echo '1.0.0.0 dom0' >> ${IMAGE_ROOTFS}/etc/hosts;
    rm -f ${IMAGE_ROOTFS}/etc/resolv.conf;
    ln -s /var/volatile/etc/resolv.conf ${IMAGE_ROOTFS}/etc/resolv.conf;
    rm -f ${IMAGE_ROOTFS}/etc/network/interfaces;
    ln -s /var/volatile/etc/network/interfaces ${IMAGE_ROOTFS}/etc/network/interfaces;
}

ROOTFS_POSTPROCESS_COMMAND += " after_commands; "

inherit image
#inherit validate-package-versions
inherit xenclient-image-src-info
inherit xenclient-image-src-package
inherit xenclient-licences
require xenclient-version.inc

LICENSE = "GPLv2 & MIT"
LIC_FILES_CHKSUM = "file://${TOPDIR}/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe      \
                    file://${TOPDIR}/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
