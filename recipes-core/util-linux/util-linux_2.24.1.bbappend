PR = "openxt-01"

# make ionice a separate package
PACKAGES =+ "util-linux-ionice"
FILES_util-linux-ionice = "${bindir}/ionice"
PROVIDES += "util-linux-ionice"
RRECOMMENDS_${PN} += "util-linux-ionice"

#TODO: Remove this once using the newer meta-selinux
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
PACKAGECONFIG[selinux] = "--with-selinux,--without-selinux,libselinux,"
#TODO: End of section to remove


