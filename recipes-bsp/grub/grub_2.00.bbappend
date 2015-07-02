PR = "openxt-01"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += "file://grub-add-sector-offset.patch \
    file://grub-2.00-branding.patch \
    file://remove-editing-and-shell.patch \
    file://accept-video-always.patch \
    "
EXTRA_OECONF += " --disable-manpages \
		--enable-graphics \
		--disable-auto-linux-mem-opt \
		--disable-werror "