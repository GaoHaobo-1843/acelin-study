package com.gaohb.hello.study.springTest.mybatis.sequence;

import java.util.Objects;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import tk.mybatis.mapper.genid.GenId;

/**
 * 序列值生成器
 * @author Admin
 */
public class SeqGenId implements GenId<String> {

    private static final Lock LOCK = new ReentrantLock();

    private static ISeqGenerator<String> seqGenerator;

    @Override
    public String genId(String table, String column) {
        ISeqGenerator<String> seqGenerator = getSeqGenerator();
        return Optional.ofNullable(seqGenerator).map(generator -> generator.genId(table, column)).orElse(null);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static ISeqGenerator<String> getSeqGenerator() {
        if (Objects.isNull(seqGenerator)) {
            LOCK.lock();
            try {
                if (Objects.nonNull(seqGenerator)) {
                    return seqGenerator;
                }
                ServiceLoader<ISeqGenerator> serviceLoader = ServiceLoader.load(ISeqGenerator.class);
                if (Objects.nonNull(serviceLoader) && serviceLoader.iterator().hasNext()) {
                    seqGenerator = serviceLoader.iterator().next();
                }
            }
            finally {
                LOCK.unlock();
            }
        }

        return seqGenerator;
    }
}
