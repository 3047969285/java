package org.dcj;

public class Computer {
    public Computer() {
    }

    // 定义use方法，可以接受USB对象
    public void use(USB usbDevice) {
        usbDevice.connect();
        if(usbDevice instanceof KeyBoard)
        {
            ((KeyBoard) usbDevice).input();
        }
        if(usbDevice instanceof Mouse)
            {
            ((Mouse) usbDevice).click();
            }
        usbDevice.exit();
    }
    
    // 也可以定义一个返回USB对象的方法
    public USB getUSBDevice() {
        return new Mouse();
    }
}