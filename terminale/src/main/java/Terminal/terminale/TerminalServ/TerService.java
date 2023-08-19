package Terminal.terminale.TerminalServ;

import Terminal.terminale.Custom.AppData;

import java.util.Collection;

public interface TerService {
    Collection<AppData> list(int limit);
    AppData Update(AppData data);
    Boolean delete(Long id);
    AppData Create(AppData data);
}
