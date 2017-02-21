# Copyright 2011 The Android Open Source Project
#
LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_SRC_FILES := $(call all-subdir-java-files)
LOCAL_STATIC_JAVA_LIBRARIES := gson android-support-v4
LOCAL_MODULE := stiletto-common
LOCAL_MODULE_TAGS := optional
LOCAL_JAR_EXCLUDE_FILES := none
include $(BUILD_STATIC_JAVA_LIBRARY)

include $(CLEAR_VARS)
LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES := gson:../lib/gson-2.8.0.jar
include $(BUILD_MULTI_PREBUILT)


