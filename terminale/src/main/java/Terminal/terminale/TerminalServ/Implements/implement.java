package Terminal.terminale.TerminalServ.Implements;

import Terminal.terminale.Custom.AppData;
import Terminal.terminale.Repo.TerminalRepo;
import Terminal.terminale.TerminalServ.TerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static org.springframework.data.domain.PageRequest.of;


@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class implement implements TerService {
    private final TerminalRepo terminalRepo;
    @Override
    public Collection<AppData> list(int limit) {
        return terminalRepo.findAll(of(0,limit)).toList();
    }

    @Override
    public AppData Update(AppData data) {
        return terminalRepo.save(data);
    }

    @Override
    public Boolean delete(Long id) {
        terminalRepo.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public AppData Create(AppData data) {
        return terminalRepo.save(data);
    }
}
