package fr.acxio.tools.agia.alfresco;

/*
 * Copyright 2014 Acxio
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.rmi.RemoteException;

import org.alfresco.webservice.content.ContentServiceSoapBindingStub;
import org.alfresco.webservice.repository.RepositoryServiceSoapBindingStub;

import com.googlecode.sardine.Sardine;

/**
 * <p>
 * Wrapper for Alfresco webservices client API.
 * </p>
 * <p>
 * The purpose of this wrapper is to make the API available as a bean in a
 * Spring context, because the API is mainly made of static classes and methods.
 * </p>
 * 
 * @author pcollardez
 *
 */

public interface AlfrescoService {

    /**
     * Returns the endpoint address of the Alfresco webservices.
     * 
     * @return the endpoint address of the Alfresco webservices.
     */
    String getEndpointAddress();

    /**
     * Returns the webapp address of Alfresco.
     * 
     * @return the webapp address of Alfresco.
     */
    String getWebappAddress();

    /**
     * Returns the username for Alfresco.
     * 
     * @return the username for Alfresco.
     */
    String getUsername();

    /**
     * Returns the password for Alfresco.
     * 
     * @return the password for Alfresco.
     */
    String getPassword();

    /**
     * Returns the timeout delay used to estimate if the session has timed out
     * on the server.
     * 
     * @return the timeout delay used to estimate if the session has timed out.
     */
    long getTimeOutInterval();

    /**
     * <p>
     * Starts a new Alfresco session with the provided endpoint address,
     * username and password.
     * </p>
     * <p>
     * This implementation checks if a ticket is available into the static
     * cache, and if so, re-use it instead of creating a new session.
     * </p>
     * 
     * @throws RemoteException
     *             if the session cannot be started
     */
    void startSession() throws RemoteException;

    /**
     * <p>
     * Puts an end to the session.
     * </p>
     * <p>
     * Actually does nothing and let the session timeout.
     * </p>
     */
    void endSession();

    /**
     * Returns the ticket of the session.
     * 
     * @return the ticket of the session.
     */
    String getTicket();

    /**
     * Starts a new WebDav session against Alfresco.
     * 
     * @return a new WebDav session against Alfresco.
     */
    Sardine startWebDavSession();

    /**
     * <p>
     * Repository service accessor.
     * </p>
     * 
     * @return the repository service stub.
     */
    RepositoryServiceSoapBindingStub getRepositoryService();

    /**
     * <p>
     * Content service accessor.
     * </p>
     * 
     * @return the content service stub.
     */
    ContentServiceSoapBindingStub getContentService();
}
