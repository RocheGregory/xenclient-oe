# Pulled orginal recipe from OE Classic until ready to follow upstream.

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://pseudo-xattr-support.patch"
DEPENDS += "attr"
