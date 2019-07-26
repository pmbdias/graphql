package br.gov.mg.fazenda.graphqlweb.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mg.fazenda.graphqlweb.service.ModelExternoService;
import br.gov.mg.fazenda.graphqlweb.service.ModelInternoService;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;
import io.leangen.graphql.metadata.strategy.type.DefaultTypeTransformer;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;

@RestController
public class GraphQLController {
	private static final Logger LOGGER = LoggerFactory.getLogger(GraphQLController.class);

	private final GraphQL graphQL;

	@Autowired
	public GraphQLController(ModelExternoService modelExternoService, ModelInternoService modelInternoService) { 

		//Schema generated from query classes
		GraphQLSchema schema = new GraphQLSchemaGenerator()
				.withResolverBuilders(
						//Resolve by annotations
						new AnnotatedResolverBuilder(),
						//Resolve public methods inside root package
						new PublicResolverBuilder("br.gov.mg.fazenda.graphqlejb"),
						new PublicResolverBuilder("br.gov.mg.fazenda.graphqlweb")
						)
				.withOperationsFromSingletons(modelExternoService, modelInternoService)
				.withValueMapperFactory(new JacksonValueMapperFactory())
				.withTypeTransformer(new DefaultTypeTransformer(true, true))
				.generate();
		graphQL = GraphQL.newGraphQL(schema).build();

		System.out.println();
		System.out.println("####### Schema ########");
		System.out.println("## schema.getAdditionalTypes(): " + schema.getAdditionalTypes());
		System.out.println();
		System.out.println("## schema.getAllTypesAsList(): " + schema.getAllTypesAsList());
		System.out.println();
		System.out.println("## schema.getFieldVisibility(): " + schema.getFieldVisibility());
		System.out.println();
		System.out.println("## schema.getMutationType(): " + schema.getMutationType());
		System.out.println();
		System.out.println("## schema.getQueryType(): " + schema.getQueryType());
		System.out.println();
		System.out.println("## schema.getTypeMap(): " + schema.getTypeMap());
		System.out.println("####### Schema ########");
		System.out.println();

		LOGGER.info("Generated GraphQL schema using SPQR");

		/*final GraphQLSchema schema = new GraphQLSchemaGenerator()
                .withInterfaceMappingStrategy(new InterfaceMappingStrategy() {
                    @Override
                    public boolean supports(final AnnotatedType interfase) {
                        return interfase.isAnnotationPresent(GraphQLInterface.class);
                    }

                    @Override
                    public Collection<AnnotatedType> getInterfaces(final AnnotatedType type) {
                        @SuppressWarnings("rawtypes")
                        Class clazz = ClassUtils.getRawType(type.getType());
                        final Set<AnnotatedType> interfaces = new HashSet<>();
                        do {
                            final AnnotatedType currentType = GenericTypeReflector.getExactSuperType(type, clazz);
                            if (supports(currentType)) {
                                interfaces.add(currentType);
                            }
                            Arrays.stream(clazz.getInterfaces())
                                    .map(inter -> GenericTypeReflector.getExactSuperType(type, inter))
                                    .filter(this::supports).forEach(interfaces::add);
                        } while ((clazz = clazz.getSuperclass()) != Object.class && clazz != null);
                        return interfaces;
                    }			
                })//.withOperationsFromSingletons(personQuery,socialNetworkQuery,vendorQuery,domainQuery,productQuery, animalService)// register the service
                	.withOperationsFromSingletons(protocoloService)
                	.withTypeTransformer(new DefaultTypeTransformer(true, true))
                .generate(); // done ;)

        graphQL = new GraphQL.Builder(schema).build();*/
	}

	@PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> indexFromAnnotated(@RequestBody Map<String, String> request, HttpServletRequest raw) {
		ExecutionResult executionResult = graphQL.execute(ExecutionInput.newExecutionInput()
				.query(request.get("query"))
				.operationName(request.get("operationName"))
				.context(raw)
				.build());
		return executionResult.toSpecification();
	}

	/*@RequestMapping(value = "/graphql", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object executeOperation(@RequestBody Map body) {
        String query = (String) body.get("query");
        Map<String, Object> variables = (Map<String, Object>) body.get("variables");
        if (variables == null) {
            variables = new LinkedHashMap<>();
        }
        ExecutionResult executionResult = graphql.execute(query, (Object) null, variables);
        Map<String, Object> result = new LinkedHashMap<>();
        if (executionResult.getErrors().size() > 0) {
            result.put("errors", executionResult.getErrors());
            log.error("Errors: {}", executionResult.getErrors());
        }
        result.put("data", executionResult.getData());
        return result;
    }
	 */
}