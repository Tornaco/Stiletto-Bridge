# Copyright 2011 The Android Open Source Project
#
LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_SRC_FILES := $(call all-subdir-java-files)
LOCAL_SRC_FILES += aidl/com/android/commands/stiletto/IStiletto.aidl
LOCAL_STATIC_JAVA_LIBRARIES := gson android-support-v4 stiletto-common guava
LOCAL_MODULE := stiletto
LOCAL_MODULE_TAGS := optional
include $(BUILD_JAVA_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE := stiletto
LOCAL_SRC_FILES := stiletto
LOCAL_MODULE_CLASS := EXECUTABLES
LOCAL_MODULE_TAGS := optional
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES := gson:lib/gson-2.8.0.jar
include $(BUILD_MULTI_PREBUILT)


