PR = "openxt-01"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += "file://zlib-inflate-checkpoint.patch \
           file://zlib-deflate-checkpoint.patch \
           "

