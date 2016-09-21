/**
 * CurrencyRateServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ties456.webservice.client.currencyrate;

public class CurrencyRateServiceImplServiceLocator extends org.apache.axis.client.Service implements ties456.webservice.client.currencyrate.CurrencyRateServiceImplService {

    public CurrencyRateServiceImplServiceLocator() {
    }


    public CurrencyRateServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CurrencyRateServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CurrencyRateServiceImplPort
    private java.lang.String CurrencyRateServiceImplPort_address = "http://localhost:9000/CurrencyRateService";

    public java.lang.String getCurrencyRateServiceImplPortAddress() {
        return CurrencyRateServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CurrencyRateServiceImplPortWSDDServiceName = "CurrencyRateServiceImplPort";

    public java.lang.String getCurrencyRateServiceImplPortWSDDServiceName() {
        return CurrencyRateServiceImplPortWSDDServiceName;
    }

    public void setCurrencyRateServiceImplPortWSDDServiceName(java.lang.String name) {
        CurrencyRateServiceImplPortWSDDServiceName = name;
    }

    public ties456.webservice.client.currencyrate.CurrencyRateServiceImpl getCurrencyRateServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CurrencyRateServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCurrencyRateServiceImplPort(endpoint);
    }

    public ties456.webservice.client.currencyrate.CurrencyRateServiceImpl getCurrencyRateServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ties456.webservice.client.currencyrate.CurrencyRateServiceImplPortBindingStub _stub = new ties456.webservice.client.currencyrate.CurrencyRateServiceImplPortBindingStub(portAddress, this);
            _stub.setPortName(getCurrencyRateServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCurrencyRateServiceImplPortEndpointAddress(java.lang.String address) {
        CurrencyRateServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ties456.webservice.client.currencyrate.CurrencyRateServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                ties456.webservice.client.currencyrate.CurrencyRateServiceImplPortBindingStub _stub = new ties456.webservice.client.currencyrate.CurrencyRateServiceImplPortBindingStub(new java.net.URL(CurrencyRateServiceImplPort_address), this);
                _stub.setPortName(getCurrencyRateServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CurrencyRateServiceImplPort".equals(inputPortName)) {
            return getCurrencyRateServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://currencyrate.webservice.ties456/", "CurrencyRateServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://currencyrate.webservice.ties456/", "CurrencyRateServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CurrencyRateServiceImplPort".equals(portName)) {
            setCurrencyRateServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
