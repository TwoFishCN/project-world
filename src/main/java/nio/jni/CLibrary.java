package nio.jni;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public interface CLibrary extends Library {

    void printf(String format, Object... args);

    CLibrary INSTANCE = Native.load((Platform.isWindows() ? "msvcrt" : "c"), CLibrary.class);
}
