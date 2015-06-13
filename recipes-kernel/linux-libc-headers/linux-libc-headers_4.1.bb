require linux-libc-headers.inc

PV_MAJOR = "${@"${PV}".split('.', 3)[0]}"

SRC_URI = "https://www.kernel.org/pub/linux/kernel/v${PV_MAJOR}.x/testing/linux-${PV}-rc7.tar.gz;name=kernel"

SRC_URI[kernel.md5sum] = "fe74533a2e3923fd32c35a42ba2c4d8f"
SRC_URI[kernel.sha256sum] = "b41fe6b9fb932c786850d3c64289f9dbcfa3da6fea76f57b7b3da3fd4b3d6c9a"


LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

S = "${WORKDIR}/linux-${PV}-rc7"

PR = "1"
