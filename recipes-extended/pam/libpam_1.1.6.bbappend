PR = "openxt-01"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += "file://etc-config-passwd.patch \
"

EXTRA_OECONF += "--disable-nis"

