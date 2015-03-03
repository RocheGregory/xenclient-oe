PR = "openxt-01"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += "file://etc-config-passwd.patch"

EXTRA_OECONF += "--disable-nis"

RDEPENDS_${PN}-runtime += " pam-plugin-selinux"

# TODO: Remove once using new meta-selinux layer
def target_selinux(d, truevar = 'selinux', falsevar = ''):
    if not bb.utils.contains("DISTRO_FEATURES", "selinux", True, False, d):
        return falsevar

    pn = d.getVar("PN", True) 
    type = pn.replace(d.getVar("BPN", True), "") 
    if type in ("-native", "nativesdk-", "-cross", "-crosssdk"):
        return falsevar

    return truevar 

LIBSELINUX = "${@target_selinux(d, 'libselinux')}"

PACKAGECONFIG_append = " ${@target_selinux(d)}"
PACKAGECONFIG[selinux] = "--enable-selinux,--disable-selinux,libselinux,"
# End section to remove
