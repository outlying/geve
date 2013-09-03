package com.antyzero.geve;

import com.google.api.client.http.GenericUrl;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Author: outlying
 * Date: 03.09.13
 * Time: 12:54
 */
public class UrlBuilder extends GenericUrl {

    public static final String PATH_PART_EVE = "/eve";

    public static final String PARAMETER_IDS = "IDs";
    public static final String PARAMETER_NAMES = "names";
    public static final String PARAMETER_KEY_ID = "keyID";
    public static final String PARAMETER_VERIFICATION_CODE = "vCode";
    public static final String PARAMETER_CHARACTER_ID = "characterID";

    /**
     * The Alliance List API retrieves a complete list of all currentl alliances in EVE Online. Closed alliances are
     * not included in the list.
     *
     * @return
     */

    public static String urlAllianceList(){

        UrlBuilder builder = builderEve();

        builder.appendRawPath( "/AllianceList.xml.aspx" );

        return builder.build();
    }

    /**
     * The Certificate Tree API returns a list of certificates in EVE.
     *
     * @return
     */

    public static String urlCertificateTree(){

        UrlBuilder builder = builderEve();

        builder.appendRawPath( "/CertificateTree.xml.aspx" );

        return builder.build();
    }

    /**
     *
     *
     * @return
     */

    public static String urlCharacterID( String... names ){

        UrlBuilder builder = builderEve();

        builder.appendRawPath( "/CharacterID.xml.aspx" );

        if( names.length > 0 ){
            builder.put( PARAMETER_NAMES, StringUtils.join( names, ',' ) );
        }

        return builder.build();
    }

    /**
     *
     *
     * @param ids
     * @return
     */

    public static String urlCharacterName( Long... ids ){

        UrlBuilder builder = builderEve();

        builder.appendRawPath( "/CharacterName.xml.aspx" );

        builder.put( PARAMETER_IDS, StringUtils.join( ids, ',' ) );

        return builder.build();
    }

    /**
     *
     *
     * @param characterID
     * @param keyID
     * @param vCode
     * @return
     */

    public static String urlCharacterInfo( Long characterID, Long keyID, String vCode ){

        UrlBuilder builder = builderEve();

        builder.appendRawPath( "/CharacterInfo.xml.aspx" );

        if( characterID != null ){
            builder.put( PARAMETER_CHARACTER_ID, characterID );
        }

        addKeyCode( builder, keyID, vCode );

        return builder.build();
    }

    /**
     * ...
     *
     * @param characterID
     * @return
     */

    public static String urlCharacterInfo( Long characterID ){

        return urlCharacterInfo( characterID, null, null );
    }

    /**
     * Url builder for Eve url group
     *
     * @return
     */

    public static UrlBuilder builderEve(){

        UrlBuilder builder = builderBase();

        builder.appendRawPath( PATH_PART_EVE );

        return builder;
    }

    /**
     * Builds base URL
     *
     * @return
     */

    public static UrlBuilder builderBase(){

        UrlBuilder builder = new UrlBuilder();

        builder.setScheme( "https" );
        builder.setHost( "api.eveonline.com" );

        return builder;
    }

    /**
     *
     *
     * @param builder
     * @param key
     * @param code
     */

    private static void addKeyCode( UrlBuilder builder, Long key, String code ){

        if( key != null && code != null ){
            builder.put( PARAMETER_KEY_ID           , key  );
            builder.put( PARAMETER_VERIFICATION_CODE, code );
        }
    }

    /**
     * Converts parts array to list
     *
     * @param parts
     * @return
     */

    private static List<String> parts( String... parts ){

        List<String> list = Arrays.asList( parts );

        return list;
    }
}
