import redis.clients.jedis.Jedis;

public class RedisJava {

    Jedis jedis;
    DeepThought super_computer;
    public RedisJava(){
        String redisHost = System.getenv("REDIS_HOST");
        if (redisHost == null || redisHost.isEmpty()) {
        throw new IllegalArgumentException("REDIS_HOST environment variable is not set or empty.");
    }
        String redisPortStr = System.getenv("REDIS_PORT");
        int redisPort = (redisPortStr != null && !redisPortStr.isEmpty()) ? Integer.parseInt(redisPortStr) : 6379;
        this.jedis = new Jedis(redisHost, redisPort);
    }

    public void cache_value(String key, String value){
        this.jedis.set(key, value);
    }

    public String get_cached_value(String key){
        return this.jedis.get(key);
    }

}

