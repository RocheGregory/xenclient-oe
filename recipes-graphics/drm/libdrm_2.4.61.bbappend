PR = "openxt-01"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += " \
            file://libdrm-foreign.patch \
           "
           
EXTRA_OECONF += "--disable-manpages"
