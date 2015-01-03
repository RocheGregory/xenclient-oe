# Pulled orginal recipe from OE Classic until ready to follow upstream.

FILESEXTRAPATHS := "${THISDIR}/${PN}"
SRC_URI += "file://pseudo-xattr-support.patch"
DEPENDS += "attr"
