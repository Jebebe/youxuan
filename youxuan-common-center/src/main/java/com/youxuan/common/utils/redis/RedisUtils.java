package com.youxuan.common.utils.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author: jebe
 * @Date: 2020/1/3 10:47
 * @Desc Redis工具类
 */
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public RedisUtils() {
    }

    public boolean expire(String key, long time) {
        this.checkKey(key);

        try {
            if (time > 0L) {
                this.redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception var5) {
            var5.printStackTrace();
            return false;
        }
    }

    public Boolean expireAt(String key, Date date) {
        this.checkKey(key);
        return this.redisTemplate.expireAt(key, date);
    }

    public long getExpire(String key) {
        return this.redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    public boolean hasKey(String key) {
        try {
            return this.redisTemplate.hasKey(key);
        } catch (Exception var3) {
            var3.printStackTrace();
            return false;
        }
    }

    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                this.redisTemplate.delete(key[0]);
            } else {
                this.redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }

    }

    public Object get(String key) {
        return key == null ? null : this.redisTemplate.opsForValue().get(key);
    }

    public boolean set(String key, Object value) {
        this.checkKey(key);

        try {
            this.redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception var4) {
            var4.printStackTrace();
            return false;
        }
    }

    public boolean set(String key, Object value, long time) {
        this.checkKey(key);

        try {
            if (time > 0L) {
                this.redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                this.set(key, value);
            }

            return true;
        } catch (Exception var6) {
            var6.printStackTrace();
            return false;
        }
    }

    public void mSet(Map<String, Object> map) {
        ValueOperations<String, Object> valueOperations = this.redisTemplate.opsForValue();
        valueOperations.multiSet(map);
    }

    public Boolean mSetNx(Map<String, Object> map) {
        ValueOperations<String, Object> valueOperations = this.redisTemplate.opsForValue();
        return valueOperations.multiSetIfAbsent(map);
    }

    public Object getSet(String key, Object value) {
        this.checkKey(key);
        ValueOperations<String, Object> valueOperations = this.redisTemplate.opsForValue();
        return valueOperations.getAndSet(key, value);
    }

    public List<Object> mGet(Collection<String> keys) {
        ValueOperations<String, Object> valueOperations = this.redisTemplate.opsForValue();
        return valueOperations.multiGet(keys);
    }

    public Boolean setBit(String key, long offset, boolean value) {
        this.checkKey(key);
        ValueOperations<String, Object> valueOperations = this.redisTemplate.opsForValue();
        return valueOperations.setBit(key, offset, value);
    }

    public Boolean getBit(String key, long offset) {
        this.checkKey(key);
        ValueOperations<String, Object> valueOperations = this.redisTemplate.opsForValue();
        return valueOperations.getBit(key, offset);
    }

    public long incr(String key, long delta) {
        this.checkKey(key);
        if (delta < 0L) {
            throw new RuntimeException("递增因子必须大于0");
        } else {
            return this.redisTemplate.opsForValue().increment(key, delta);
        }
    }

    public long decr(String key, long delta) {
        this.checkKey(key);
        if (delta < 0L) {
            throw new RuntimeException("递减因子必须大于0");
        } else {
            return this.redisTemplate.opsForValue().increment(key, -delta);
        }
    }

    public Object hget(String key, String item) {
        this.checkKey(key);
        this.checkField(item);
        return this.redisTemplate.opsForHash().get(key, item);
    }

    public Map<Object, Object> hmget(String key) {
        this.checkKey(key);
        return this.redisTemplate.opsForHash().entries(key);
    }

    public List<Object> hmget(String key, Collection<String> fields) {
        this.checkKey(key);
        if (CollectionUtils.isEmpty(fields)) {
            throw new IllegalArgumentException("fields列表不能为空");
        } else {
            HashOperations<String, String, Object> hashOperations = this.redisTemplate.opsForHash();
            return hashOperations.multiGet(key, fields);
        }
    }

    public boolean hmset(String key, Map<String, Object> map) {
        this.checkKey(key);

        try {
            this.redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception var4) {
            var4.printStackTrace();
            return false;
        }
    }

    public boolean hmset(String key, Map<String, Object> map, long time) {
        this.checkKey(key);

        try {
            this.redisTemplate.opsForHash().putAll(key, map);
            if (time > 0L) {
                this.expire(key, time);
            }

            return true;
        } catch (Exception var6) {
            var6.printStackTrace();
            return false;
        }
    }

    public boolean hset(String key, String item, Object value) {
        this.checkKey(key);

        try {
            this.redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception var5) {
            var5.printStackTrace();
            return false;
        }
    }

    public boolean hset(String key, String item, Object value, long time) {
        this.checkKey(key);
        this.checkField(item);

        try {
            this.redisTemplate.opsForHash().put(key, item, value);
            if (time > 0L) {
                this.expire(key, time);
            }

            return true;
        } catch (Exception var7) {
            var7.printStackTrace();
            return false;
        }
    }

    public void hdel(String key, Object... item) {
        this.redisTemplate.opsForHash().delete(key, item);
    }

    public boolean hhaskey(String key, String item) {
        return this.redisTemplate.opsForHash().hasKey(key, item);
    }

    public double hincr(String key, String item, double by) {
        return this.redisTemplate.opsForHash().increment(key, item, by);
    }

    public double hdecr(String key, String item, double by) {
        return this.redisTemplate.opsForHash().increment(key, item, -by);
    }

    public Boolean hSetNX(String key, String field, Object value) {
        this.checkKey(key);
        this.checkField(field);
        HashOperations<String, String, Object> hashOperations = this.redisTemplate.opsForHash();
        return hashOperations.putIfAbsent(key, field, value);
    }

    public List<Object> values(String key) {
        this.checkKey(key);
        HashOperations<String, String, Object> hashOperations = this.redisTemplate.opsForHash();
        return hashOperations.values(key);
    }

    public Set<Object> sGet(String key) {
        this.checkKey(key);

        try {
            return this.redisTemplate.opsForSet().members(key);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public boolean sHasKey(String key, Object value) {
        this.checkKey(key);

        try {
            return this.redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception var4) {
            var4.printStackTrace();
            return false;
        }
    }

    public long sSet(String key, Object... values) {
        this.checkKey(key);

        try {
            return this.redisTemplate.opsForSet().add(key, values);
        } catch (Exception var4) {
            var4.printStackTrace();
            return 0L;
        }
    }

    public long sSetAndTime(String key, long time, Object... values) {
        this.checkKey(key);

        try {
            Long count = this.redisTemplate.opsForSet().add(key, values);
            if (time > 0L) {
                this.expire(key, time);
            }

            return count;
        } catch (Exception var6) {
            var6.printStackTrace();
            return 0L;
        }
    }

    public long sGetSetSize(String key) {
        this.checkKey(key);

        try {
            return this.redisTemplate.opsForSet().size(key);
        } catch (Exception var3) {
            var3.printStackTrace();
            return 0L;
        }
    }

    public long setRemove(String key, Object... values) {
        this.checkKey(key);

        try {
            return this.redisTemplate.opsForSet().remove(key, values);
        } catch (Exception var4) {
            var4.printStackTrace();
            return 0L;
        }
    }

    public Object sPop(String key) {
        this.checkKey(key);
        SetOperations<String, Object> setOperations = this.redisTemplate.opsForSet();
        return setOperations.pop(key);
    }

    public Set<Object> sInter(String key, String otherKey) {
        this.checkKey(key);
        this.checkOtherKey(otherKey);
        SetOperations<String, Object> setOperations = this.redisTemplate.opsForSet();
        return setOperations.intersect(key, otherKey);
    }

    public Set<Object> sInter(String key, Collection<String> otherKeys) {
        this.checkKey(key);
        if (CollectionUtils.isEmpty(otherKeys)) {
            throw new IllegalArgumentException("key 集合不能为空");
        } else {
            SetOperations<String, Object> setOperations = this.redisTemplate.opsForSet();
            return setOperations.intersect(key, otherKeys);
        }
    }

    public Long sInterStore(String key, String otherKey, String destKey) {
        this.checkKey(key);
        this.checkOtherKey(otherKey);
        this.checkDestKey(destKey);
        SetOperations<String, Object> setOperations = this.redisTemplate.opsForSet();
        return setOperations.intersectAndStore(key, otherKey, destKey);
    }

    public Long sInterStore(String key, Collection<String> otherKeys, String destKey) {
        SetOperations<String, Object> setOperations = this.checkKeyOtherKeyDestKey(key, otherKeys, destKey);
        return setOperations.intersectAndStore(key, otherKeys, destKey);
    }

    public Object sRandMember(String key) {
        this.checkKey(key);
        SetOperations<String, Object> setOperations = this.redisTemplate.opsForSet();
        return setOperations.randomMember(key);
    }

    public Set<Object> distinctRandomMembers(String key, long count) {
        this.checkKey(key);
        SetOperations<String, Object> setOperations = this.redisTemplate.opsForSet();
        return setOperations.distinctRandomMembers(key, count);
    }

    public List<Object> randomMembers(String key, long count) {
        this.checkKey(key);
        SetOperations<String, Object> setOperations = this.redisTemplate.opsForSet();
        return setOperations.randomMembers(key, count);
    }

    public List<Object> lGet(String key, long start, long end) {
        this.checkKey(key);

        try {
            return this.redisTemplate.opsForList().range(key, start, end);
        } catch (Exception var7) {
            var7.printStackTrace();
            return null;
        }
    }

    public Long lPush(String key, Object value) {
        this.checkKey(key);
        ListOperations<String, Object> listOperations = this.redisTemplate.opsForList();
        return listOperations.leftPush(key, value);
    }

    public long lGetListSize(String key) {
        this.checkKey(key);

        try {
            return this.redisTemplate.opsForList().size(key);
        } catch (Exception var3) {
            var3.printStackTrace();
            return 0L;
        }
    }

    public Object lGetIndex(String key, long index) {
        this.checkKey(key);

        try {
            return this.redisTemplate.opsForList().index(key, index);
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public boolean lSet(String key, Object value) {
        this.checkKey(key);

        try {
            this.redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception var4) {
            var4.printStackTrace();
            return false;
        }
    }

    public boolean lSet(String key, Object value, long time) {
        this.checkKey(key);

        try {
            this.redisTemplate.opsForList().rightPush(key, value);
            if (time > 0L) {
                this.expire(key, time);
            }

            return true;
        } catch (Exception var6) {
            var6.printStackTrace();
            return false;
        }
    }

    public boolean lSet(String key, List<Object> value) {
        this.checkKey(key);

        try {
            this.redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception var4) {
            var4.printStackTrace();
            return false;
        }
    }

    public boolean lSet(String key, List<Object> value, long time) {
        this.checkKey(key);

        try {
            this.redisTemplate.opsForList().rightPushAll(key, value);
            if (time > 0L) {
                this.expire(key, time);
            }

            return true;
        } catch (Exception var6) {
            var6.printStackTrace();
            return false;
        }
    }

    public boolean lUpdateIndex(String key, long index, Object value) {
        this.checkKey(key);

        try {
            this.redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception var6) {
            var6.printStackTrace();
            return false;
        }
    }

    public long lRemove(String key, long count, Object value) {
        this.checkKey(key);

        try {
            return this.redisTemplate.opsForList().remove(key, count, value);
        } catch (Exception var6) {
            var6.printStackTrace();
            return 0L;
        }
    }

    public Object lPop(String key) {
        this.checkKey(key);
        ListOperations<String, Object> listOperations = this.redisTemplate.opsForList();
        return listOperations.leftPop(key);
    }

    public Object rPopLPush(String source, String destination) {
        this.checkKey(source);
        this.checkDestKey(destination);
        ListOperations<String, Object> listOperations = this.redisTemplate.opsForList();
        return listOperations.rightPopAndLeftPush(source, destination);
    }

    public Object rPop(String key) {
        this.checkKey(key);
        ListOperations<String, Object> listOperations = this.redisTemplate.opsForList();
        return listOperations.rightPop(key);
    }

    public Boolean zAdd(String key, Object value, double score) {
        this.checkKey(key);
        ZSetOperations<String, Object> zSetOperations = this.redisTemplate.opsForZSet();
        return zSetOperations.add(key, value, score);
    }

    public Long zRemove(String key, Object... values) {
        this.checkKey(key);
        ZSetOperations<String, Object> zSetOperations = this.redisTemplate.opsForZSet();
        return zSetOperations.remove(key, values);
    }

    public Double zIncrBy(String key, Object value, double delta) {
        this.checkKey(key);
        ZSetOperations<String, Object> zSetOperations = this.redisTemplate.opsForZSet();
        return zSetOperations.incrementScore(key, value, delta);
    }

    public Long zRank(String key, Object value) {
        this.checkKey(key);
        ZSetOperations<String, Object> zSetOperations = this.redisTemplate.opsForZSet();
        return zSetOperations.rank(key, value);
    }

    public Long zRevRank(String key, Object value) {
        this.checkKey(key);
        ZSetOperations<String, Object> zSetOperations = this.redisTemplate.opsForZSet();
        return zSetOperations.reverseRank(key, value);
    }

    public Set<Object> zRange(String key, long start, long end) {
        this.checkKey(key);
        ZSetOperations<String, Object> zSetOperations = this.redisTemplate.opsForZSet();
        return zSetOperations.range(key, start, end);
    }

    public Map<Object, Double> zRangeWithScores(String key, long start, long end) {
        this.checkKey(key);
        ZSetOperations<String, Object> zSetOperations = this.redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<Object>> set = zSetOperations.rangeWithScores(key, start, end);
        Map<Object, Double> map = new HashMap(32);
        if (!CollectionUtils.isEmpty(set)) {
            set.forEach((e) -> {
                map.put(e.getValue(), e.getScore());
            });
        }

        return map;
    }

    public Set<Object> zRangeByScore(String key, double min, double max) {
        this.checkKey(key);
        ZSetOperations<String, Object> zSetOperations = this.redisTemplate.opsForZSet();
        return zSetOperations.rangeByScore(key, min, max);
    }

    public Map<Object, Double> zRangeByScoreWithScores(String key, double min, double max) {
        this.checkKey(key);
        ZSetOperations<String, Object> zSetOperations = this.redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<Object>> typedTuples = zSetOperations.rangeByScoreWithScores(key, min, max);
        Map<Object, Double> map = new HashMap(32);
        if (!CollectionUtils.isEmpty(typedTuples)) {
            typedTuples.forEach((e) -> {
                map.put(e.getValue(), e.getScore());
            });
        }

        return map;
    }

    public Set<Object> zRangeByScore(String key, double min, double max, long offset, long count) {
        this.checkKey(key);
        ZSetOperations<String, Object> zSetOperations = this.redisTemplate.opsForZSet();
        return zSetOperations.rangeByScore(key, min, max, offset, count);
    }

    public Map<Object, Double> zRangeByScoreWithScores(String key, double min, double max, long offset, long count) {
        this.checkKey(key);
        ZSetOperations<String, Object> zSetOperations = this.redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<Object>> typedTuples = zSetOperations.rangeByScoreWithScores(key, min, max, offset, count);
        Map<Object, Double> map = new HashMap(32);
        if (!CollectionUtils.isEmpty(typedTuples)) {
            typedTuples.forEach((e) -> {
                map.put(e.getValue(), e.getScore());
            });
        }

        return map;
    }

    public Set<Object> zReverseRange(String key, long start, long end) {
        this.checkKey(key);
        ZSetOperations<String, Object> zSetOperations = this.redisTemplate.opsForZSet();
        return zSetOperations.reverseRange(key, start, end);
    }

    public Map<Object, Double> zReverseRangeWithScores(String key, long start, long end) {
        this.checkKey(key);
        ZSetOperations<String, Object> zSetOperations = this.redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<Object>> typedTuples = zSetOperations.reverseRangeWithScores(key, start, end);
        Map<Object, Double> map = new HashMap(32);
        if (!CollectionUtils.isEmpty(typedTuples)) {
            typedTuples.forEach((e) -> {
                map.put(e.getValue(), e.getScore());
            });
        }

        return map;
    }

    public Set<Object> zReverseRangeByScore(String key, double min, double max) {
        this.checkKey(key);
        ZSetOperations<String, Object> zSetOperations = this.redisTemplate.opsForZSet();
        return zSetOperations.reverseRangeByScore(key, min, max);
    }

    public Map<Object, Double> zReverseRangeByScoreWithScores(String key, double min, double max) {
        this.checkKey(key);
        ZSetOperations<String, Object> zSetOperations = this.redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<Object>> typedTuples = zSetOperations.reverseRangeByScoreWithScores(key, min, max);
        Map<Object, Double> map = new HashMap(32);
        if (!CollectionUtils.isEmpty(typedTuples)) {
            typedTuples.forEach((e) -> {
                Double var10000 = (Double) map.put(e.getValue(), e.getScore());
            });
        }

        return map;
    }

    public Map<Object, Double> zReverseRangeByScoreWithScores(String key, double min, double max, long offset, long count) {
        this.checkKey(key);
        ZSetOperations<String, Object> zSetOperations = this.redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<Object>> typedTuples = zSetOperations.reverseRangeByScoreWithScores(key, min, max, offset, count);
        Map<Object, Double> map = new HashMap(32);
        typedTuples.forEach((e) -> {
            Double var10000 = (Double) map.put(e.getValue(), e.getScore());
        });
        return map;
    }

    public Set<Object> zReverseRangeByScore(String key, double min, double max, long offset, long count) {
        this.checkKey(key);
        ZSetOperations<String, Object> zSetOperations = this.redisTemplate.opsForZSet();
        return zSetOperations.reverseRangeByScore(key, min, max, offset, count);
    }

    public Long zCount(String key, double min, double max) {
        this.checkKey(key);
        ZSetOperations<String, Object> zSetOperations = this.redisTemplate.opsForZSet();
        return zSetOperations.count(key, min, max);
    }

    public Double zScore(String key, Object value) {
        this.checkKey(key);
        ZSetOperations<String, Object> zSetOperations = this.redisTemplate.opsForZSet();
        return zSetOperations.score(key, value);
    }

    public Long pfAdd(String key, Object... values) {
        this.checkKey(key);
        HyperLogLogOperations<String, Object> hyperLogLogOperations = this.redisTemplate.opsForHyperLogLog();
        return hyperLogLogOperations.add(key, values);
    }

    public Long pfCount(String... keys) {
        HyperLogLogOperations<String, Object> hyperLogLogOperations = this.redisTemplate.opsForHyperLogLog();
        return hyperLogLogOperations.size(keys);
    }

    public Long hllUnion(String destination, String... sourceFinal) {
        this.checkDestKey(destination);
        HyperLogLogOperations<String, Object> hyperLogLogOperations = this.redisTemplate.opsForHyperLogLog();
        return hyperLogLogOperations.union(destination, sourceFinal);
    }

    private void checkClientId(String clientId) {
        if (StringUtils.isEmpty(clientId)) {
            throw new IllegalArgumentException("clientId 不能为空");
        }
    }

    private void checkKey(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new IllegalArgumentException("key不能为空");
        }
    }

    private void checkPattern(String pattern) {
        if (StringUtils.isEmpty(pattern)) {
            throw new IllegalArgumentException("pattern不能为空");
        }
    }

    private void checkOtherKey(String otherKey) {
        if (StringUtils.isEmpty(otherKey)) {
            throw new IllegalArgumentException("otherKey不能为空");
        }
    }

    private void checkDestKey(String otherKey) {
        if (StringUtils.isEmpty(otherKey)) {
            throw new IllegalArgumentException("destKey不能为空");
        }
    }

    private void checkField(String field) {
        if (StringUtils.isEmpty(field)) {
            throw new IllegalArgumentException("field不能为空");
        }
    }

    private SetOperations<String, Object> checkKeyOtherKeyDestKey(String key, Collection<String> otherKeys, String destKey) {
        this.checkKey(key);
        this.checkDestKey(destKey);
        if (CollectionUtils.isEmpty(otherKeys)) {
            throw new IllegalArgumentException("key 集合不能为空");
        } else {
            return this.redisTemplate.opsForSet();
        }
    }
}
