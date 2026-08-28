package com.ecommerce.order_service.mappers;

import org.mapstruct.Mapper;

import com.ecommerce.order_service.dtos.OrderLineItemRequest;
import com.ecommerce.order_service.dtos.OrderLineItemResponse;
import com.ecommerce.order_service.dtos.OrderRequest;
import com.ecommerce.order_service.dtos.OrderResponse;
import com.ecommerce.order_service.models.Order;
import com.ecommerce.order_service.models.OrderLineItems;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    // 1. De Request a Entidad
    Order toOrder(OrderRequest orderRequest);

    // Método auxiliar (MapStruct lo usa automáticamente para convertir cada ítem de la lista)
    // Aquí NO hace falta @Mapping porque los campos (sku, price, quantity) se llaman igual.
    OrderLineItems toOrderLineItems(OrderLineItemRequest orderLineItemsRequest);


    // 2. De Entidad a Response
    OrderResponse toOrderResponse(Order order);

    // Método auxiliar para la respuesta
    // Aquí NO hace falta @Mapping porque los campos (id, sku, price, quantity) se llaman igual.
    OrderLineItemResponse toOrderLineItemsResponse(OrderLineItems orderLineItems);
}
