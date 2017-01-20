package com.auth0.json.mgmt.users;

import com.auth0.json.JsonMatcher;
import com.auth0.json.JsonTest;
import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class UserTest extends JsonTest<User> {

    private static final String json = "{\"connection\":\"auth0\",\"client_id\":\"client123\",\"password\":\"pwd\",\"verify_password\":true,\"username\":\"usr\",\"email\":\"me@auth0.com\",\"email_verified\":true,\"verify_email\":true,\"phone_number\":\"1234567890\",\"phone_verified\":true,\"verify_phone_number\":true,\"picture\":\"https://pic.ture/12\",\"name\":\"John\",\"nickname\":\"Johny\",\"given_name\":\"John\",\"family_name\":\"Walker\",\"created_at\":\"12:12:12\",\"updated_at\":\"12:12:12\",\"identities\":[],\"app_metadata\":{},\"user_metadata\":{},\"last_ip\":\"10.0.0.1\",\"last_login\":\"12:12:12\",\"logins_count\":10,\"blocked\":true}";
    private static final String readOnlyJson = "{\"user_id\":\"user|123\"}";

    @Test
    public void shouldSerialize() throws Exception {
        User user = new User("auth0");
        user.setPassword("pwd");
        user.setVerifyPassword(true);
        user.setUsername("usr");
        user.setEmail("me@auth0.com");
        user.setClientId("client123");
        user.setVerifyEmail(true);
        user.setEmailVerified(true);
        user.setPhoneNumber("1234567890");
        user.setVerifyPhoneNumber(true);
        user.setPhoneVerified(true);
        user.setPicture("https://pic.ture/12");
        user.setName("John");
        user.setNickname("Johny");
        user.setGivenName("John");
        user.setFamilyName("Walker");
        user.setCreatedAt("12:12:12");
        user.setUpdatedAt("12:12:12");
        user.setIdentities(Collections.<Identity>emptyList());
        user.setUserMetadata(Collections.<String, Object>emptyMap());
        user.setAppMetadata(Collections.<String, Object>emptyMap());
        user.setLastIp("10.0.0.1");
        user.setLastLogin("12:12:12");
        user.setLoginsCount(10);
        user.setBlocked(true);

        String serialized = toJSON(user);
        assertThat(serialized, is(notNullValue()));

        assertThat(serialized, JsonMatcher.hasEntry("connection", "auth0"));
        assertThat(serialized, JsonMatcher.hasEntry("password", "pwd"));
        assertThat(serialized, JsonMatcher.hasEntry("verify_password", true));
        assertThat(serialized, JsonMatcher.hasEntry("username", "usr"));
        assertThat(serialized, JsonMatcher.hasEntry("email", "me@auth0.com"));
        assertThat(serialized, JsonMatcher.hasEntry("verify_email", true));
        assertThat(serialized, JsonMatcher.hasEntry("email_verified", true));
        assertThat(serialized, JsonMatcher.hasEntry("client_id", "client123"));
        assertThat(serialized, JsonMatcher.hasEntry("phone_number", "1234567890"));
        assertThat(serialized, JsonMatcher.hasEntry("verify_phone_number", true));
        assertThat(serialized, JsonMatcher.hasEntry("phone_verified", true));
        assertThat(serialized, JsonMatcher.hasEntry("picture", "https://pic.ture/12"));
        assertThat(serialized, JsonMatcher.hasEntry("name", "John"));
        assertThat(serialized, JsonMatcher.hasEntry("nickname", "Johny"));
        assertThat(serialized, JsonMatcher.hasEntry("given_name", "John"));
        assertThat(serialized, JsonMatcher.hasEntry("family_name", "Walker"));
        assertThat(serialized, JsonMatcher.hasEntry("created_at", "12:12:12"));
        assertThat(serialized, JsonMatcher.hasEntry("updated_at", "12:12:12"));
        assertThat(serialized, JsonMatcher.hasEntry("identities", notNullValue()));
        assertThat(serialized, JsonMatcher.hasEntry("user_metadata", notNullValue()));
        assertThat(serialized, JsonMatcher.hasEntry("app_metadata", notNullValue()));
        assertThat(serialized, JsonMatcher.hasEntry("last_ip", "10.0.0.1"));
        assertThat(serialized, JsonMatcher.hasEntry("last_login", "12:12:12"));
        assertThat(serialized, JsonMatcher.hasEntry("logins_count", 10));
        assertThat(serialized, JsonMatcher.hasEntry("blocked", true));
    }

    @Test
    public void shouldDeserialize() throws Exception {
        User user = fromJSON(json, User.class);

        assertThat(user, is(notNullValue()));
        assertThat(user.getConnection(), is("auth0"));
        assertThat(user.getPassword(), is("pwd"));
        assertThat(user.getVerifyPassword(), is(true));
        assertThat(user.getUsername(), is("usr"));
        assertThat(user.getEmail(), is("me@auth0.com"));
        assertThat(user.getVerifyEmail(), is(true));
        assertThat(user.getClientId(), is("client123"));
        assertThat(user.getEmailVerified(), is(true));
        assertThat(user.getPhoneNumber(), is("1234567890"));
        assertThat(user.getVerifyPhoneNumber(), is(true));
        assertThat(user.getPhoneVerified(), is(true));
        assertThat(user.getPicture(), is("https://pic.ture/12"));
        assertThat(user.getName(), is("John"));
        assertThat(user.getNickname(), is("Johny"));
        assertThat(user.getGivenName(), is("John"));
        assertThat(user.getFamilyName(), is("Walker"));
        assertThat(user.getCreatedAt(), is("12:12:12"));
        assertThat(user.getUpdatedAt(), is("12:12:12"));
        assertThat(user.getIdentities(), is(notNullValue()));
        assertThat(user.getUserMetadata(), is(notNullValue()));
        assertThat(user.getAppMetadata(), is(notNullValue()));
        assertThat(user.getLastIp(), is("10.0.0.1"));
        assertThat(user.getLastLogin(), is("12:12:12"));
        assertThat(user.getLoginsCount(), is(10));
        assertThat(user.getBlocked(), is(true));
    }

    @Test
    public void shouldIncludeReadOnlyValuesOnDeserialize() throws Exception {
        User user = fromJSON(readOnlyJson, User.class);
        assertThat(user, is(notNullValue()));

        assertThat(user.getId(), is("user|123"));
    }
}