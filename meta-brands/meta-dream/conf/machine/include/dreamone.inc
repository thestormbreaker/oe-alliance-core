SUMMARY ?= "A Dreambox firmware image for headless systems"

# packages to drag into the image
IMAGE_INSTALL = " \
    packagegroup-boot-systemd \
    packagegroup-net-connman \
    packagegroup-pkg-deb \
    packagegroup-opendreambox-base \
    packagegroup-opendreambox-dvbapi3 \
"

# enable online package management
IMAGE_FEATURES = "package-management"

# we don't want any locales, at least not in the common way.
IMAGE_LINGUAS = ""

# 512MB rootfs
IMAGE_ROOTFS_SIZE_ext4 = "524288"
