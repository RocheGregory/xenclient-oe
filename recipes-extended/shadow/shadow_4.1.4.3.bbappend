
SHADOW_EXTRAPATH := "${THISDIR}/files"
FILESEXTRAPATHS_prepend := "${SHADOW_EXTRAPATH}:"

SRC_URI += "file://login.selinux"

do_install_append_class-target() {
	install -m 0644 ${WORKDIR}/login.selinux ${D}${sysconfdir}/pam.d/login
}
