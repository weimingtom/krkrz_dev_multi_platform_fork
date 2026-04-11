LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE:= libogg

LOCAL_C_INCLUDES := $(LOCAL_PATH)/include \
	$(LOCAL_PATH)/src \
	$(LOCAL_PATH)

LOCAL_CFLAGS +=

LOCAL_SRC_FILES := \
src/bitwise.c \
src/framing.c

include $(BUILD_STATIC_LIBRARY)
