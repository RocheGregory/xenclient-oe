FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI =+ "https://raw.githubusercontent.com/wiki/SELinuxProject/selinux/files/releases/${SELINUX_RELEASE}/${BPN}-${PV}.tar.gz \
            file://checkpolicy-Do-not-link-against-libfl.patch"
