import com.intellij.codeInsight.template.CustomLiveTemplate;
import com.intellij.codeInsight.template.impl.DefaultLiveTemplatesProvider;
import org.jetbrains.annotations.Nullable;

public class pycDjangoSnippets implements DefaultLiveTemplatesProvider{

    @Override
    public String[] getDefaultLiveTemplateFiles(){
        return new String[] {
                "liveTemplates/pycDjangoSnippets_templates"
        };
    }

    @Nullable
    @Override
    public String[] getHiddenLiveTemplateFiles(){
        return new String[0];
    }
}
