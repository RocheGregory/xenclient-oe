# Pulled in older meta-selinux recipe to keep alive.  Make sure to kill the full recipe
# include file and folder when ready to go upstream.

SRC_URI =+ "https://raw.githubusercontent.com/wiki/SELinuxProject/selinux/files/releases/${SELINUX_RELEASE}/${BPN}-${PV}.tar.gz"
