package vicvega.maxdome;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import android.content.Context;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class MaxdomeXposed implements IXposedHookLoadPackage {
	public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("de.maxdome.app.android"))
            return;
        findAndHookMethod("com.insidesecure.drmagent.v2.internal.DRMAgentNativeBridge", lpparam.classLoader, "isSecureDevice", Context.class, XC_MethodReplacement.returnConstant(true));        
    }
}
