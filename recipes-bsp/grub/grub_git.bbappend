PR = "openxt-01"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-git:"

EXTRA_OECONF += " --disable-manpages \
		--enable-graphics \
		--disable-auto-linux-mem-opt \
		--disable-werror"

PACKAGECONFIG = "device-mapper"