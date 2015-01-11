SRC_URI += "\
    file://icedtea-ecj-fix-currency-data.patch;apply=no \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

export DISTRIBUTION_ECJ_PATCHES += " \
    patches/icedtea-ecj-fix-currency-data.patch \
"

#Allow icedtea to build on 4.0+ host kernels.
export DISABLE_HOTSPOT_OS_VERSION_CHECK = "1"

PR .= ".1"
