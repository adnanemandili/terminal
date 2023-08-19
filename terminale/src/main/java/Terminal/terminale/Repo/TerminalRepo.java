package Terminal.terminale.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import Terminal.terminale.Custom.AppData;

public interface TerminalRepo extends JpaRepository<AppData,Long> {
}
