package com.example.mikro;

import com.example.mikro.model.LogEntry;
import com.example.mikro.repository.LogRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    @Autowired
    private LogRepository logRepository;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("✅ Filtro ejecutado");

        long startTime = System.currentTimeMillis();
        filterChain.doFilter(request, response);
        long duration = System.currentTimeMillis() - startTime;

        String mensaje = String.format("[%s] %s %s → %d en %dms",
                LocalDateTime.now(),
                request.getMethod(),
                request.getRequestURI(),
                response.getStatus(),
                duration
        );

        try {
         LogEntry log = new LogEntry(mensaje);
            logRepository.save(log);
            System.out.println("✅ Log guardado en Mongo: " + mensaje);
        } catch (Exception e) {
            System.out.println("❌ Error al guardar en Mongo: " + e.getMessage());
        }
    }
}
