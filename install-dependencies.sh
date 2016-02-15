#!/bin/bash

# Fix the CircleCI path
export PATH="$ANDROID_HOME/platform-tools:$ANDROID_HOME/tools:$PATH"

DEPS="$ANDROID_HOME/installed-dependencies"

if [ ! -e $DEPS ]; then
  echo y | android update sdk -u -a -t android-23 &&
  echo y | android update sdk -u -a -t platform-tools &&
  echo y | android update sdk -u -a -t extra &&
  echo y | android update sdk -u -a -t build-tools-23.1.0 &&
  echo y | android update sdk -u -a -t sys-img-x86-android-23 &&
  echo y | android update sdk -u -a -t addon-google_apis-google-23 &&
  echo n | android create avd -n testing -f -t android-23 &&
  touch $DEPS
fi