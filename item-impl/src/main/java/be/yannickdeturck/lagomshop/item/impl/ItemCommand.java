package be.yannickdeturck.lagomshop.item.impl;

import be.yannickdeturck.lagomshop.item.api.AddItemRequest;
import be.yannickdeturck.lagomshop.item.api.AddItemResponse;
import be.yannickdeturck.lagomshop.item.api.Item;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lightbend.lagom.javadsl.immutable.ImmutableStyle;
import com.lightbend.lagom.javadsl.persistence.PersistentEntity;
import com.lightbend.lagom.serialization.CompressedJsonable;
import com.lightbend.lagom.serialization.Jsonable;
import org.immutables.value.Value;

import java.util.Optional;

public interface ItemCommand extends Jsonable {

    @Value.Immutable
    @ImmutableStyle
    @JsonDeserialize
    public interface AbstractAddItem extends ItemCommand, CompressedJsonable, PersistentEntity.ReplyType<AddItemResponse> {

        @Value.Parameter
        AddItemRequest getAddItemRequest();
    }

    @Value.Immutable(singleton = true)
    @ImmutableStyle
    @JsonDeserialize
    public interface AbstractGetItem extends ItemCommand, CompressedJsonable, PersistentEntity.ReplyType<GetItemReply> {

    }

    @Value.Immutable
    @ImmutableStyle
    @JsonDeserialize
    public interface AbstractGetItemReply extends Jsonable {

        @Value.Parameter
        Optional<Item> getItem();
    }
}
