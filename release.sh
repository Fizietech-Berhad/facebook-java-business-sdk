# Copyright (c) Meta Platforms, Inc. and affiliates.
# All rights reserved.

# This source code is licensed under the license found in the
# LICENSE file in the root directory of this source tree.

main() {
  echo "start config"
  set -e
  case $1 in
    "config_maven") config_maven "$@" ;;
  esac
}


config_maven(){
  if [[ -z "${OSSRH_USERNAME}" || -z "${OSSRH_TOKEN}" ]]; then
    die "ERROR: Variables OSSRH_USERNAME or OSSRH_TOKEN not defined"
    exit 201
  fi

  if [[ -z "${GPG_KEYNAME}" || -z "${GPG_PASSPHRASE}" ]]; then
    die "ERROR: Variables GPG_KEYNAME or GPG_PASSPHRASE not defined"
    exit 201
  fi

  cat <<EOF> ./.github/workflows/settings.xml
<settings>
  <profiles>
    <profile>
      <id>ossrh</id>
      <activation>
        <activeByDefault>true</activeByDefault>
      </activation>
      <properties>
        <gpg.executable>gpg</gpg.executable>
        <gpg.keyname>${GPG_KEYNAME}</gpg.keyname>
        <gpg.passphrase>${GPG_PASSPHRASE}</gpg.passphrase>
      </properties>
    </profile>
  </profiles>
  <servers>
    <server>
      <id>ossrh</id>
      <username>${OSSRH_USERNAME}</username>
      <password>${OSSRH_TOKEN}</password>
    </server>
  </servers>
</settings>
EOF
}

die() {
  echo ""
  echo "FATAL: $*" >&2
  exit 1
}

main "$@"
