package com.zxx.serial;

import com.caucho.hessian.io.HessianSerializerInput;
import com.caucho.hessian.io.HessianSerializerOutput;
import org.junit.Test;

import java.io.*;

/**
 * @author Administrator
 * @date 2020/04/20
 */
public class TestHessianSerial {

    @Test
    public void testHessianSerial() throws IOException {
     /*   OutputStream os = new ObjectOutputStream(new FileOutputStream("test.txt"));
        PersonHessian ph = new PersonHessian();
        ph.setId(12343L);
        ph.setName("小明");
        ph.setMale(true);
        HessianSerializerOutput serializerOutput = new HessianSerializerOutput(os);
        serializerOutput.writeObject(ph);
        serializerOutput.close();
        os.close();*/
        InputStream is = new ObjectInputStream(new FileInputStream("test.txt"));
        HessianSerializerInput serializerInput = new HessianSerializerInput(is);
        Object object = serializerInput.readObject();
        is.close();
        System.out.println(object);
    }
}
