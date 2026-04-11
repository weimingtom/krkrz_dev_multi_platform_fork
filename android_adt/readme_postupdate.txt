NotifyWindowInvalidation
AddUpdateRegion
UpdateChildRegion
InternalUpdate
Update(
RequestInvalidation
NotifyWindowExposureToLayer
InvalidateAll
void TTVPWindowForm::UpdateWindow(tTVPUpdateType type) {
case AM_SURFACE_PAINT_REQUEST:
void tTJSNI_Window::Update(tTVPUpdateType type)



void TJS_INTF_METHOD tTJSNI_Window::NotifyLayerImageChange(class iTVPLayerManager* manager)
{
    


    
    
#ifdef WIN32
    if( DrawDevice ) DrawDevice->NotifyLayerImageChange(manager);
#endif
}


tTJSNativeClass* TVPCreateDefaultDrawDevice() {
    TVPInitDrawDeviceOptions();
#ifdef WIN32
    if( TVPEnableDrawDevice )
        return new tTJSNC_BasicDrawDevice();
    else
#endif
        return new tTJSNC_NullDrawDevice();
}


class tTVPNullDrawDevice : public iTVPDrawDevice
{
public:
    ~tTVPNullDrawDevice() {}
    void TJS_INTF_METHOD Destruct() override { delete this; }
    void TJS_INTF_METHOD SetWindowInterface(iTVPWindow * window) override {}
    void TJS_INTF_METHOD AddLayerManager(iTVPLayerManager * manager) override {}
    void TJS_INTF_METHOD RemoveLayerManager(iTVPLayerManager * manager) override {}
    void TJS_INTF_METHOD SetTargetWindow(HWND wnd, bool is_main) override {}
    void TJS_INTF_METHOD SetDestRectangle(const tTVPRect & rect) override {}
    void TJS_INTF_METHOD SetClipRectangle(const tTVPRect & rect) override {}
    void TJS_INTF_METHOD GetSrcSize(tjs_int &w, tjs_int &h) override {}
    void TJS_INTF_METHOD NotifyLayerResize(iTVPLayerManager * manager) override {}
    void TJS_INTF_METHOD NotifyLayerImageChange(iTVPLayerManager * manager) override {
#if defined(ANDROID)
TVPAddLog(TJS_W("tTVPNullDrawDevice::NotifyLayerImageChange 1"));
#endif    
    }



	