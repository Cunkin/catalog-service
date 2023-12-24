#Build
custom_build(
    # Name of container image
    ref = 'catalog-service',
    # Command to build container image
    command = './mvnw spring-boot:build-image -DimageName=$EXPECTED_REF',
    # Files to watch that trigger a new build
    deps = ['pom.xml', 'src']
)

# Deploy
k8s_yaml(kustomize('k8s'))

# Manage
k8s_resource('catalog-service', port_forwards=['9001'])