package org.usergrid;


import org.junit.rules.TestRule;
import org.usergrid.persistence.Entity;
import org.usergrid.persistence.Query;
import org.usergrid.persistence.Results;

import java.util.Map;
import java.util.UUID;


/**
 * A Usergrid Application object used to simplify Test code by making it much
 * more readable and removing unnecessary clutter due to boilerplate code. Use
 * concrete instances of Application from various modules like
 * {@link CoreApplication} with the Rule and ClassRule annotations to create
 * unique Applications in Usergrid for use in testing.
 */
public interface Application extends TestRule
{
    /**
     * Gets the Application's UUID.
     *
     * @return the UUID of the application
     */
    UUID getId();

    /**
     * Clears the properties associated with this Application.
     */
    void clear();

    /**
     * Gets a property value managed by this Application.
     *
     * @param key the key associated with the property
     * @return the value of the property
     */
    Object get( String key );

    /**
     * Puts a property value into the Application.
     *
     * @param property the key of the property
     * @param value the value of the property
     * @return the last value held by the property
     */
    Object put( String property, Object value );

    /**
     * Gets the Map of properties associated with this Application.
     *
     * @return the Map of properties associated with this Application
     */
    Map<String,Object> getProperties();

    /**
     * Gets the name of the organization this Application is associated with.
     *
     * @return the name of this Application's organization
     */
    @SuppressWarnings( "UnusedDeclaration" )
    String getOrgName();

    /**
     * Gets the name of this Application.
     *
     * @return the name of this Application
     */
    @SuppressWarnings( "UnusedDeclaration" )
    String getAppName();

    /**
     * Gets an entity associated with this Application based on it's type.
     *
     * @param type the type of the entity
     * @return the entity
     * @throws Exception if something goes wrong accessing the entity
     */
    Entity create( String type ) throws Exception;

    /**
     * Gets an entity associated with this Application by unique id.
     *
     * @param id the unique identifier for the entity associated with this Application
     * @return the entity associated with this Application
     * @throws Exception if anything goes wrong accessing the entity
     */
    Entity get( UUID id ) throws Exception;

    /**
     * Adds an item to a collection associated with this Application.
     *
     * @param user the user adding the item
     * @param collection the collection the item is added to
     * @param item the entity being added to the collection
     * @throws Exception if anything goes wrong adding the item to the specified collection
     */
    void addToCollection( Entity user, String collection, Entity item ) throws Exception;

    /**
     * Searches a collection for items satisfying a Query.
     *
     * @param user the user performing the query
     * @param collection the collection being queried
     * @param query the query to apply for selecting items in the collection
     * @return the set of items resulting from the query
     * @throws Exception if anything goes wrong querying the specified collection
     */
    Results searchCollection( Entity user, String collection, Query query ) throws Exception;

    /**
     * Puts all of the properties into this Application's properties.
     *
     * @param properties the Map of property key value pairs
     */
    void putAll( Map<String, Object> properties );
}
