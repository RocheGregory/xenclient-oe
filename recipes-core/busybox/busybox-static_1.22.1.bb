require repos/openembedded-core/meta/recipes-core/busybox/busybox_${PV}.bb

S = "${WORKDIR}/busybox-${PV}"

do_configure_append() {
	sed -i -e '/CONFIG_STATIC/d' .config
	echo "CONFIG_STATIC=y" >>.config
}

