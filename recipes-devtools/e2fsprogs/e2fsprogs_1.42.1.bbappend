PR = "openxt-01"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"
DEPENDS += "libbudgetvhd"
SRC_URI += "file://vhd.patch"
SRC_URI += "file://autofix-sb-future-timestamps.patch"
SRC_URI += "file://fix-infinite-recursion.patch"

#do_configure_append() {
#    autoconf
#}

