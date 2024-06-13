package org.example.proxy;

import org.example.builder.Pessoa;

public interface ProxyPessoa {
    void save(Pessoa pessoa);
    Pessoa findById(Long id);
}
