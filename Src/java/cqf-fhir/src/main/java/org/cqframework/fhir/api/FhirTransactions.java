package org.cqframework.fhir.api;

import org.hl7.fhir.instance.model.api.IBaseBundle;

/**
 * Defines an interface for providing transaction support in the Fhir platform API.
 */
public interface FhirTransactions {

    /**
     * Executes the given transaction bundle, as defined by the FHIR transaction processing rules:
     * https://hl7.org/fhir/http.html#transaction
     *
     * Note specifically that this interface can also be used to process a `batch` bundle (i.e. a set of
     * FHIR API requests that can be performed with a single API request, but does not require full
     * transaction semantics.
     *
     * @param transaction A bundle defining the transaction to be executed
     * @return A bundle containing the result of executing the transaction
     */
    IBaseBundle transaction(IBaseBundle transaction);
}