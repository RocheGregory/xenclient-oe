SRC_URI += "\
    file://icedtea-ecj-fix-currency-data.patch;apply=no \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

export DISTRIBUTION_ECJ_PATCHES += " \
    patches/icedtea-ecj-fix-currency-data.patch \
"
