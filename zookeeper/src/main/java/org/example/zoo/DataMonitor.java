package org.example.zoo;

import lombok.Data;

@Data
public class DataMonitor {
    public interface Listener {
        void exists(byte[] data);
        void closing(int rc);
    }
}
