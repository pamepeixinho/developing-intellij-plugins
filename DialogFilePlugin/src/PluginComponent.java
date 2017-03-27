import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

/**
 * Created by PamelaPeixinho on 26/03/17.
 */
public class PluginComponent implements ApplicationComponent {

	@Override
	public void initComponent() {
		System.out.print("init component");
	}

	@Override
	public void disposeComponent() {
		System.out.print("component");
	}

	@NotNull
	@Override
	public String getComponentName() {
		return null;
	}
}
