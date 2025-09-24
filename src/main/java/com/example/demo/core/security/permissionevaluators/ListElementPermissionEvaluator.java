package com.example.demo.core.security.permissionevaluators;

import com.example.demo.domain.listelement.ListElementRepository;
import com.example.demo.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("ListElementPermissionEvaluator")
@RequiredArgsConstructor
public class ListElementPermissionEvaluator {

    private final ListElementRepository listElementRepository;

    public boolean isOwner(User principal, UUID elementId) {
        return listElementRepository.findById(elementId)
                .map(listElement -> listElement.getOwner().getId().equals(principal.getId()))
                .orElse(false);
    }

    public boolean isNotOwner(User principal, UUID elementId) {
        return listElementRepository.findById(elementId)
                .map(listElement -> !listElement.getOwner().getId().equals(principal.getId()))
                .orElse(false);
    }

    public boolean canCreate(User principal, UUID targetUserId) {
        return targetUserId != null && targetUserId.equals(principal.getId());
    }
}
