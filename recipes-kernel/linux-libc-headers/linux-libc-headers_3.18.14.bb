require linux-libc-headers.inc

PV_MAJOR = "${@"${PV}".split('.', 3)[0]}"

SRC_URI = "https://www.kernel.org/pub/linux/kernel/v${PV_MAJOR}.x/linux-${PV}.tar.gz;name=kernel"

SRC_URI[kernel.md5sum] = "8c49740da53f2098deee2f9fb6dfcc6a"
SRC_URI[kernel.sha256sum] = "227f325e95942d9170025fa910bbb568b31f09effc97a4119f5f0fa20626e3a0"


LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

S = "${WORKDIR}/linux-${PV}"

PR = "1"
