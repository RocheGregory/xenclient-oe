inherit xenclient

require recipes-kernel/linux/linux.inc

DEPENDS += "xz-native bc-native"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
KERNEL_IMAGETYPE = "bzImage"

FILESEXTRAPATHS_prepend := "${THISDIR}/files-4.1:"

SRC_URI = "https://www.kernel.org/pub/linux/kernel/v4.x/testing/linux-${PV}-rc7.tar.xz;name=kernel \
    file://defconfig \
    "

#SRC_URI = "https://www.kernel.org/pub/linux/kernel/v3.x/linux-${PV}.tar.xz;name=kernel \
#    file://xen-acpi-wmi.patch \
#    file://bridge-carrier-follow-prio0.patch \
#    file://privcmd-mmapnocache-ioctl.patch \
#    file://usb-mass-storage-no-autobind.patch \
#    file://xenkbd-tablet-resolution.patch \
#    file://skb-forward-copy-bridge-param.patch \
#    file://break-8021d.patch \
#    file://extra-mt-input-devices.patch \
#    file://tpm-log-didvid.patch \
#    file://alsa-driver.patch \
#    file://blktap2.patch \
#    file://export-for-xenfb2.patch \
#    file://allow-service-vms.patch \
#    file://intel-amt-support.patch \
#    file://disable-csum-xennet.patch \
#    file://enable-pat.patch \
#    file://pci-pt-move-unaligned-resources.patch;patch=1 \
#    file://pci-pt-flr.patch;patch=1 \
#    file://netback-skip-frontend-wait-during-shutdown.patch;patch=1 \
#    file://xenbus-move-otherend-watches-on-relocate.patch;patch=1 \
#    file://netfront-support-backend-relocate.patch;patch=1 \
#    file://konrad-microcode.patch;patch=1 \
#    file://konrad-ioperm.patch;patch=1 \
#    "


#SRC_URI = "http://mirror.openxt.org/linux-3.11.10.4.tar.gz;name=kernel \
#
#    file://guest-os-controlled-brightness-support.patch;patch=1 \
#    file://acpi-video-delay-init.patch;patch=1 \
#    file://dont-suspend-xen-serial-port.patch;patch=1 \
#    file://realmem-mmap.patch;patch=1 \
#    file://stubdom-allow-foreign-lowmem-map.patch;patch=1 \
#    
#    
#    
#    
#    
#    
#    
#    
#    
#    
#    
#    
#    file://gem-userptr.patch;patch=1 \
#    file://gem-foreign.patch;patch=1 \
#    file://gem-foreign-debug.patch;patch=1 \
#    file://atmel-tpm-timeouts.patch;patch=1 \
#    file://fbcon-do-not-drag-detect-primary-option.patch;patch=1 \
#    file://usbback-base.patch;patch=1 \
#    file://usbback-rolled-up-patches.patch;patch=1 \
#    file://usbback-req-padding.patch;patch=1 \
#    file://usbback-optional-configuration.patch;patch=1 \
#    file://usbback-async-urb-free.patch;patch=1 \
#    file://usbback-map-ring-valloc.patch;patch=1 \
#"

SRC_URI[kernel.md5sum] = "7d6d143c9e2d14ec036f645bb69605c8"
SRC_URI[kernel.sha256sum] = "4e4c3bbd301da616781d4b0c7f3c530f7ef90d5d00141296a37f276a419d7d25"

S = "${WORKDIR}/linux-${PV}-rc7"

